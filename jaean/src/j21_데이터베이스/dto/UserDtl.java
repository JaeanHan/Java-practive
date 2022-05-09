package j21_데이터베이스.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDtl extends User {
	private int usercode;
	private String address;
	private String phone;
	private int gender;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
