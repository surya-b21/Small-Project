import java.util.*;
public class ATM {
static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String ID;
		String PIN;
		// database
		String[] user = { "Joni", "Jono" };
		String[] pin = { "1234", "4321" };
		int [] saldo = { 5000000, 10000000 };
		int [] code = new int [5];
//comment
		System.out.println("Silahkan Masukkan ID dan Pin anda!");
		System.out.print("ID : ");
		ID = input.next();
		System.out.print("Password : ");
		PIN = input.next();
		for (int i = 0; i < user.length; i++) {
			if ((ID.equals(user[i])) && (PIN.equals(pin[i]))) {
				System.out.println("Berhasil Login!!!");
				System.out.println("Selamat datang " + user[i]);
				System.out.println("Silahkan pilih menu yang diinginkan");

				System.out.print("1. Info Saldo \n2. Tarik Tunai \n3. Transfer \nSilahkan Pilih Menu : ");
				int menu = input.nextInt();
				switch (menu) {
				case 1:
					System.out.print("Saldo anda adalah " + saldo[i]);
					break;
				case 2:
					System.out.println("Pilih jumlah paket tunai :");
					System.out.println("1. Rp. 50000\n2. Rp. 1000000\n3. Rp. 300000\n4. Rp. 500000\n5. Rp. 1000000\n6. Input Manual");
					System.out.print("Pilih menu : ");
					int pilih = input.nextInt();
					if (pilih==1) {
						System.out.println("Saldo anda sekarang : "+tariktunai(saldo,pilih,i));
					}
					else if (pilih==2) {
						System.out.println("Saldo anda sekarang : "+tariktunai(saldo,pilih,i));
					}
					else if (pilih==3) {
						System.out.println("Saldo anda sekarang : "+tariktunai(saldo,pilih,i));
					}
					else if (pilih==4) {
						System.out.println("Saldo anda sekarang : "+tariktunai(saldo,pilih,i));
					}
					else if (pilih==5) {
						System.out.println("Saldo anda sekarang : "+tariktunai(saldo,pilih,i));
					}
					else if (pilih==6) {
						System.out.println("Saldo anda sekarang : "+tariktunai(saldo,pilih,i));
					}
					for (int j=0; j<code.length; j++) {
						code[j] = (int) ((Math.random() *8)+1);
					}
					System.out.print("Kode pengambilan anda : ");
					for (int x : code) {
						System.out.print(x);
					}
					break;
					
				}
			}
		}
	}
	public static int tariktunai (int saldo[],int pilih,int i) {
		int saldoakhir = saldo[i];
		if (pilih==1) {
			return saldoakhir -= 50000;
		}
		else if (pilih==2) {
			return saldoakhir -= 100000;
		}
		else if (pilih==3) {
			return saldoakhir -= 300000;
		}
		else if (pilih==4) {
			return saldoakhir -= 500000;
		}
		else if (pilih==5) {
			return saldoakhir -= 1000000;
		}
		else if (pilih==6) {
			System.out.print("Silahkan masukkan nominal yang diinginkan : ");
			int nominal = input.nextInt();
			if (nominal>saldoakhir) {
				System.out.println("Maaf saldo anda tidak mencukupi");
			}
			return saldoakhir -= nominal;
		}
		return saldoakhir;
		
	}
}