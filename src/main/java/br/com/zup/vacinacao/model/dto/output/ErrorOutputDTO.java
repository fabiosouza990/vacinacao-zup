package br.com.zup.vacinacao.model.dto.output;

public class ErrorOutputDTO {

    private String message;

    public ErrorOutputDTO(String message) {

        this.message = message;
    }


    public String getMessage() {
        return message;
    }


}
