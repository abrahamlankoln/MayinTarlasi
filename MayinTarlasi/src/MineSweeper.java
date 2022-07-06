import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
	int satir, sutun, selectx, selecty;
	int numberOfMines;
	int right;
	String[][] map;
	String[][] map1;
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();

	public MineSweeper(int satir, int sutun) {
		this.satir = satir;
		this.sutun = sutun;
		this.map = new String[satir][sutun];
		this.map1 = new String[satir][sutun];
		this.numberOfMines = (int) (satir * sutun) / 4;
		this.right = (satir * sutun) - (numberOfMines);
	}

	void addMine() {

		for (int i = 0; i < satir; i++) {
			for (int j = 0; j < sutun; j++) {
				map[i][j] = "-";
			}
		}
		while (numberOfMines > 0) {
			int randomsat, randomsut;
			randomsat = rand.nextInt(satir);
			randomsut = rand.nextInt(sutun);
			if (map[randomsat][randomsut] != "*") {
				map[randomsat][randomsut] = "*";
				numberOfMines--;
			}
		}
	}

	void notMine() {
		for (int i = 0; i < satir; i++) {
			for (int j = 0; j < sutun; j++) {
				map1[i][j] = "-";
			}
		}

	}

	public int control(int contx, int conty) {
		int counter = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (contx + i < 0 || conty + j < 0 || contx + i >= satir || conty + j >= sutun || (i == 0 && j == 0))
					continue;
				if (map[contx + i][conty + j].equals("*"))
					counter++;
			}
		}
		return counter;
	}

	void print(String[][] arr) {
		System.out.println(" ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("============================================");
	}

	void run() {
		Scanner deger = new Scanner(System.in);
		addMine();
		notMine();
		print(map);
		print(map1);
		while (right > 0) {
			System.out.print("lutfen satir sayisini giriniz: ");
			selectx = deger.nextInt();
			System.out.print("lutfen sutun sayisini giriniz: ");
			selecty = deger.nextInt();
			System.out.println("============================================");
			if (selectx >= 0 && selectx <= satir && selecty >= 0 && selecty <= sutun) {
			if (map[selectx][selecty] == "*") {
				System.out.print("***GAME OVER***");
				break;
			} else {
				int m = control(selectx, selecty);
				map1[selectx][selecty] = String.valueOf(m);
				print(map1);
				right--;
			}
			}else {
				System.out.println("YANLIŞ SATIR SUTUN GİRDİNİZ LUTFEN TEKRAR DENEYİNİZ");
				System.out.println("============================================");
			}
		}
		if (right == 0) {
			System.out.println("***KAZANDINIZ***");
		}
	}
}
