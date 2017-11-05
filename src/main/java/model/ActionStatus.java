package model;

/**
 * Created by Przemyslaw Petka on 11/5/2017.
 */
public class ActionStatus {
    private Boolean success;
    private Integer currentLedState;
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCurrentLedState() {
        return currentLedState;
    }

    public void setCurrentLedState(Integer currentLedState) {
        this.currentLedState = currentLedState;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
