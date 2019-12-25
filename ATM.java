import java.util.*;
public class ATM {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String ID;
		String PIN;
		// database
		String [] user     = { "Joni", "Jono" };
		String [] id       = { "joni69", "jonoganteng"};
		String [] pin      = { "1234", "4321" };
		String [] norek    = { "00001" , "00002" };
		int    [] saldo    = { 5000000, 10000000 };
		int    [] code     = new int[5];
		int     i          = 0;
		boolean logincheck = false;
		boolean exitstatus = false;
		System.out.println("================");
		System.out.println("==Cardless ATM==");
		System.out.println("================");

		while (exitstatus != true) { //membuat perulangan agar bisa melakukan transaksi lagi
			System.out.println("Silahkan Masukkan ID dan Pin anda!");
			System.out.print("ID : ");
			ID = input.next();
			System.out.print("Password : ");
			PIN = input.next();
			for (i = 0; i < id.length; i++) { //pengecekan ID dan PIN melalui for dan di cek di database
				if ((ID.equals(id[i])) && (PIN.equals(pin[i]))) {
					logincheck = true;
					break;
				}
			}
			if (logincheck == true) {
				System.out.println("======================================");
					System.out.println("Berhasil Login!!!");
					System.out.println("Selamat datang " + user[i]);
					System.out.println("Silahkan pilih menu yang diinginkan");

					System.out.print("1. Info Saldo \n2. Tarik Tunai \n3. Transfer \nSilahkan Pilih Menu : ");
					int menu = input.nextInt();
					switch (menu) {
					case 1: 
						System.out.println("======================================");
						System.out.println("Saldo anda adalah Rp. " + saldo[i]);
						break;
					case 2: 
						System.out.println("======================================");
						System.out.println("Pilih jumlah paket tunai :");
						System.out.println(
								"1. Rp. 50000\n2. Rp. 100000\n3. Rp. 300000\n4. Rp. 500000\n5. Rp. 1000000\n6. Input Manual");
						System.out.print("Pilih menu : ");
						int pilih = input.nextInt();
						if (pilih == 1) {
							saldo[i] = tariktunai(saldo, pilih, i);
							System.out.println("======================================");
							System.out.println("Saldo anda sekarang : Rp. " + saldo[i]);
						} else if (pilih == 2) {
							saldo[i] = tariktunai(saldo, pilih, i);
							System.out.println("======================================");
							System.out.println("Saldo anda sekarang : Rp. " + saldo[i]);
						} else if (pilih == 3) {
							saldo[i] = tariktunai(saldo, pilih, i);
							System.out.println("======================================");
							System.out.println("Saldo anda sekarang : Rp. " + saldo[i]);
						} else if (pilih == 4) {
							saldo[i] = tariktunai(saldo, pilih, i);
							System.out.println("======================================");
							System.out.println("Saldo anda sekarang : Rp. " + saldo[i]);
						} else if (pilih == 5) {
							saldo[i] = tariktunai(saldo, pilih, i);
							System.out.println("======================================");
							System.out.println("Saldo anda sekarang : Rp. " + saldo[i]);
						} else if (pilih == 6) {
							saldo[i] = tariktunai(saldo, pilih, i);
							System.out.println("======================================");
							System.out.println("Saldo anda sekarang : Rp. " + saldo[i]);
						}
						for (int j = 0; j < code.length; j++) {
							code[j] = (int) ((Math.random() * 8) + 1);
						}
						System.out.print("Kode pengambilan anda : ");
						for (int x : code) {
							System.out.print(x);
						}
						System.out.println();
						System.out.println("======================================");
						break;
					case 3: 
						System.out.println("======================================");
						System.out.println("Silahkan isi nomor rekening tujuan anda!");
						String rek = input.next();
						int    j   = 0;
						for (j = 0;j < norek.length; j++) {
							if (rek.equals(norek[j])){
								int   [] saldobaru = transfer(saldo, i, j, user, norek);
								saldo[i]           = saldobaru[0];
								saldo[j]           = saldobaru[1];
								System.out.println("Sisa saldo anda : Rp. "+saldo[i]);
							}
						}
						break;
					}
				} else {
					System.out.println("ID/PIN anda salah");
				}
					System.out.println("Apakah anda ingin melakukan tansaksi lagi ?");
					System.out.println("Ya/Tidak");
					String lagi = input.next();
					if ((lagi.equals("Ya"))||(lagi.equals("ya"))) {
						exitstatus = false;
					} else if ((lagi.equals("Tidak"))||(lagi.equals("tidak"))) {
						System.out.println("Terima kasih");
						exitstatus = true;
					}		
			}
		}
	
		

	public static int tariktunai(int saldo[], int pilih, int i) {
		int saldoakhir = saldo[i];
		if (pilih == 1) {
			 saldoakhir -= 50000;
		} else if (pilih == 2) {
			 saldoakhir -= 100000;
		} else if (pilih == 3) {
			 saldoakhir -= 300000;
		} else if (pilih == 4) {
			 saldoakhir -= 500000;
		} else if (pilih == 5) {
			 saldoakhir -= 1000000;
		} else if (pilih == 6) {
			System.out.print("Silahkan masukkan nominal yang diinginkan : ");
			int nominal = input.nextInt();
			if (nominal > saldoakhir) {
				System.out.println("Maaf saldo anda tidak mencukupi");
			}
			 saldoakhir -= nominal;
		}
		return saldoakhir;
	}

	public static int[] transfer(int saldo[], int i, int j, String user[], String[] norek) {
		int     [] saldobaru = new int [2];
		boolean exit         = false;
		while (exit == false) {
			System.out.println("Silahkan masukkan nominal yang akan ditransfer");
			int nominal = input.nextInt();
			System.out.println("Apakah anda yakin angka mentransfer uang sebesar Rp. " + nominal + "\nKepada :"
					+ user[j] + "\nDengan Nomor Rekening : " + norek[j]);
				System.out.println("Ya/Tidak");
				String tanya = input.next();
				if ((tanya.equals("Ya")) || (tanya.equals("ya"))) {
					saldobaru[0] = saldo[i]-nominal;
					saldobaru[1] = saldo[j]+nominal;
					System.out.println("Transfer berhasil");
					exit = true;
				} else if ((tanya.equals("Tidak")) || (tanya.equals("tidak"))) {
					exit = false;
				}
			}
		return saldobaru;
	}
}