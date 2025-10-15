package lab.cryptography.crypto.entities;


import jakarta.persistence.*;
import lab.cryptography.crypto.service.EncryptService;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="tb_transactions")
public class TransactionEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "user_document")
    private String encryptedUserDocument;

    @Column(name = "credit_card_token")
    private String encryptedCreditCardToken;

    @Column(name = "transaction_value")
    private Long transactionValue;

    @Transient
    private String rawUserDocument;

    @Transient
    private String rawCreditCardToken;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getEncryptedUserDocument() {
        return encryptedUserDocument;
    }

    public void setEncryptedUserDocument(String encryptedUserDocument) {
        this.encryptedUserDocument = encryptedUserDocument;
    }

    public String getEncryptedCreditCardToken() {
        return encryptedCreditCardToken;
    }

    public void setEncryptedCreditCardToken(String encryptedCreditCardToken) {
        this.encryptedCreditCardToken = encryptedCreditCardToken;
    }

    public Long getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Long transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getRawUserDocument() {
        return rawUserDocument;
    }

    public void setRawUserDocument(String rawUserDocument) {
        this.rawUserDocument = rawUserDocument;
    }

    public String getRawCreditCard() {
        return rawCreditCardToken;
    }

    public void setRawCreditCard(String rawCreditCard) {
        this.rawCreditCardToken = rawCreditCard;
    }

    public TransactionEntity() {
    }

    public TransactionEntity(Long transactionId,
                             String encryptedUserDocument,
                             String encryptedCreditCardToken,
                             Long transactionValue,
                             String rawUserDocument,
                             String rawCreditCard )
    {

        this.transactionId = transactionId;
        this.encryptedUserDocument = encryptedUserDocument;
        this.encryptedCreditCardToken = encryptedCreditCardToken;
        this.transactionValue = transactionValue;
        this.rawUserDocument = rawUserDocument;
        this.rawCreditCardToken = rawCreditCard;
    }

    @PrePersist
    public void prePersist(){
        this.encryptedUserDocument = EncryptService.encrypt(rawUserDocument);
        this.encryptedCreditCardToken = EncryptService.encrypt(encryptedCreditCardToken);
    }

    @PostLoad
    public void postLoad(){
        this.rawUserDocument = EncryptService.decrypt(encryptedUserDocument);
        this.rawCreditCardToken = EncryptService.decrypt(encryptedCreditCardToken);
    }

}
