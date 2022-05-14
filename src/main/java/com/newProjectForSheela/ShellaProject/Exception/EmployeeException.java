package Com.Team.Creation.demo.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class EmployeeException extends Exception{
    private HttpStatus status;
    private String errorMessage;
    public EmployeeException(HttpStatus status,String errorMessage){
        super(errorMessage);
        this.status=status;
        this.errorMessage=errorMessage;
    }
}

