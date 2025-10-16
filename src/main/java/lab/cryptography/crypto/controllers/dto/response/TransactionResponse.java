package lab.cryptography.crypto.controllers.dto.response;

import lab.cryptography.crypto.entities.TransactionEntity;

public record TransactionResponse(Long id,
                                  String userDocument,
                                  String creditCardToken,
                                  Long value) {
    public static TransactionResponse fromEntity(TransactionEntity entity){
        return new TransactionResponse(
                entity.getTransactionId(),
                entity.getRawUserDocument(),
                entity.getRawCreditCard(),
                entity.getTransactionValue()
        );
    }
}



