package Exercise;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ex9 {
    public static void main(String[] args) {
//        Bài tập 1: Viết chương trình để lấy ngày hiện tại của hệ thống và các nơi bao gồm : Asia/Tokyo, Australia/Sydney ,America/Sao_Paulo
        LocalDate currentDate = LocalDate.now();
        System.out.println("Ngày hiện tại: " + currentDate);
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        ZoneId sydneyZone = ZoneId.of("Australia/Sydney");
        ZoneId saoPauloZone = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime tokyoTime = currentDate.atStartOfDay(tokyoZone);
        ZonedDateTime sydneyTime = currentDate.atStartOfDay(sydneyZone);
        ZonedDateTime saoPauloTime = currentDate.atStartOfDay(saoPauloZone);

        System.out.println("Ngày hiện tại ở Tokyo: " + tokyoTime);
        System.out.println("Ngày hiện tại ở Sydney: " + sydneyTime);
        System.out.println("Ngày hiện tại ở Sao Paulo: " + saoPauloTime);

        // Bài tập 2: Lấy thời gian hiện tại (giờ, phút, giây)
        LocalTime currentTime = LocalTime.now();
        System.out.println("Thời gian hiện tại: " + currentTime);

        // Bài tập 3: Tính số ngày giữa hai ngày
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 12, 31);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("Số ngày giữa " + date1 + " và " + date2 + " là: " + daysBetween);

        // Bài tập 4: Số ngày trong tháng hiện tại
        int daysInCurrentMonth = YearMonth.now().lengthOfMonth();
        System.out.println("Số ngày trong tháng hiện tại là: " + daysInCurrentMonth);

        // Bài tập 5: Số ngày trong năm hiện tại
        int daysInCurrentYear = Year.now().length();
        System.out.println("Số ngày trong năm hiện tại là: " + daysInCurrentYear);

        // Bài tập 6: Chuyển đổi chuỗi ngày sang LocalDate
        String dateString = "2023-08-15";
        LocalDate convertedDate = LocalDate.parse(dateString);
        System.out.println("Chuỗi ngày chuyển đổi thành LocalDate: " + convertedDate);

        // Bài tập 7: Chuyển đổi LocalDate sang chuỗi ngày
        String formattedDate = convertedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("LocalDate chuyển đổi thành chuỗi ngày: " + formattedDate);
        // Bài tập 8: Chuyển đổi LocalDateTime sang chuỗi ngày(dd/MM/yyyy HH:mm:ss)
        LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("LocalDateTime chuyển đổi thành chuỗi ngày: " + formattedDateTime);

        // Bài tập 9: So sánh hai ngày LocalDate (trả về int)
        LocalDate dateNo1 = LocalDate.of(2023, 1, 1);
        LocalDate dateNo2 = LocalDate.of(2023, 12, 31);
        int comparisonResult = date1.compareTo(date2);
        System.out.println("So sánh " + dateNo1 + " và " + dateNo2 + ": " + comparisonResult);

        // Bài tập 10: So sánh hai thời gian LocalTime
        LocalTime time1 = LocalTime.of(12, 30, 0);
        LocalTime time2 = LocalTime.of(10, 0, 0);
        int timeComparisonResult = time1.compareTo(time2);
        System.out.println("So sánh " + time1 + " và " + time2 + ": " + timeComparisonResult);

        // Bài tập 11: Thêm hoặc bớt một số ngày, giờ, phút, giây hoặc mili giây vào một ngày hoặc thời gian
        LocalDateTime modifiedDateTime = currentDateTime.plusDays(2)
                .minusHours(3)
                .plusMinutes(15);
        System.out.println("Ngày giờ sau khi thay đổi: " + modifiedDateTime);

        // Bài tập 12: Tính toán ngày tiếp theo hoặc ngày trước đó của một ngày
        LocalDate nextDate = date1.plusDays(1);
        LocalDate previousDate = date1.minusDays(1);
        System.out.println("Ngày tiếp theo của " + date1 + ": " + nextDate);
        System.out.println("Ngày trước đó của " + date1 + ": " + previousDate);

        // Bài tập 13: Tính toán thời gian tiếp theo hoặc thời gian trước đó của một thời gian
        LocalTime nextTime = time1.plusHours(1);
        LocalTime previousTime = time1.minusMinutes(30);
        System.out.println("Thời gian tiếp theo của " + time1 + ": " + nextTime);
        System.out.println("Thời gian trước đó của " + time1 + ": " + previousTime);
    }

}
