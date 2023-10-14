package utils.API.endpoints;

import lombok.Getter;

public enum Endpoints {
    LOGIN("/web/index.php/auth/login"),
    CANDIDATE("/web/index.php/api/v2/recruitment/candidates");

    @Getter
    private final String value;
    Endpoints(String value) {
        this.value = value;
    }
}
