package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Mine {
	// FileReader: 입력기반 스트림
	// FileReader fr = new FileReader(FILE_NAME);
	// BufferedReader: 보조 스트림 (줄단위로 텍스트를 가져오는 기능)
	// BufferedReader br = new BufferedReader(fr);
	// 한줄씩 가져오기~
	// String line = br.readLine();

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		// 주문 기록을 저장할 파일 경로
		String filePath = "C:\\cjh\\workspace\\ProjectMini\\src\\main\\order.txt";

		while (true) {
			System.out.println("1. 상품 주문하기");
			System.out.println("2. 전체 주문 이력 보기");
			System.out.println("3. 고객별 주문 이력 보기");
			System.out.println("4. 특정날짜에 들어온 주문이력 보기");
			System.out.println("5. 끝내기");
			System.out.print("옵션을 선택하세요: ");

			int num = scanner.nextInt();
			scanner.nextLine(); // 버퍼 비우기 (다음 줄을 위한)

			if (num == 1) {
				
				// 고객명 입력받기
				System.out.print("고객명: ");
				String customerName = scanner.nextLine();

				// 상품명 입력받기
				System.out.print("제품명: ");
				String productName = scanner.nextLine();

				// 상품 수량 입력받기
				System.out.print("제품수량: ");
				int productNum = scanner.nextInt();

				// 상품 가격 입력받기
				System.out.print("제품가격: ");
				int productPrice = scanner.nextInt();
				scanner.nextLine(); // 버퍼 비우기 (다음 줄을 위한)

				// 현재시간 가져오기
				LocalDateTime curDateTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formattedDateTime = curDateTime.format(formatter);

				// 메모장 라인 읽어오기
				FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr);
				
				int linenum = 0;
				while (br.readLine() != null) {
					linenum++;
				}
				br.close();
				
				String customerList = "주문번호: "+ (linenum + 1) + ", "
						+ "고객명: " + customerName + ", "
						+ "제품명: " + productName + ", "
						+ "제품수량: " + productNum + ", "
						+ "제품가격: " + productPrice + ", "
						+ "주문일시: " + formattedDateTime; 
				
				// 파일에 저장
				FileWriter fw = new FileWriter(filePath, true); 
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(customerList);
				bw.newLine();
				bw.flush();
				bw.close();

				System.out.println("주문이 저장되었습니다.");
				
			} else if(num == 2) { // 2번 전체 주문 이력 보기
				
				FileReader fr = new FileReader(filePath);
				while(true) {
					int i = fr.read();
					if(i == -1) { 
						break;
					}
					System.out.print((char) i);
				}
				
			} else if (num == 3) { // 3번 고객별 주문 이력 보기
				
				
				
			} else if (num == 5) { // 5번 프로그램 종료
				break; 
			}
		}


	}

}

