import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int satir;
		int sutun;
		Scanner deger = new Scanner(System.in);
		System.out.print("lutfen satir sayisini giriniz: ");
		satir = deger.nextInt();
		System.out.print("lutfen sutun sayisini giriniz: ");
		sutun = deger.nextInt();
		System.out.println("OYUN BASLADI");
		System.out.print("============================================");
		MineSweeper a = new MineSweeper(satir, sutun);
		a.run();
	}

}
