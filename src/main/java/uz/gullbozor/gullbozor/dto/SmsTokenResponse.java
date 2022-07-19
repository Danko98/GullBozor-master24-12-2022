package uz.gullbozor.gullbozor.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SmsTokenResponse {

    private Object object;
    private Long generateNumber;
    private boolean success;
    private String massage;

    public SmsTokenResponse(Object object, Long generateNumber) {
        this.object = object;
        this.generateNumber = generateNumber;
    }

    public SmsTokenResponse(String massage, boolean success) {
        this.success = success;
        this.massage = massage;
    }

}
