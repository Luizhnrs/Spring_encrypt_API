package lab.cryptography.crypto.controllers.dto.request;

public record CreateTransactionRequest (String userDocument,
                                       String creditCardToken,
                                       Long value) {

}
