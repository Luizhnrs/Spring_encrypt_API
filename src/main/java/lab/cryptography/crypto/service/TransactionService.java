package lab.cryptography.crypto.service;

import lab.cryptography.crypto.controllers.dto.request.CreateTransactionRequest;
import lab.cryptography.crypto.controllers.dto.response.TransactionResponse;
import lab.cryptography.crypto.entities.TransactionEntity;
import lab.cryptography.crypto.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository repository;


    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void create(CreateTransactionRequest request){
        var entity = new TransactionEntity();
        entity.setRawCreditCard(request.creditCardToken());
        entity.setRawUserDocument(request.userDocument());
        entity.setTransactionValue(request.value());
    }

    public Page<TransactionResponse> listAll(int page, int pageSize){
        var content = repository.findAll(PageRequest.of(page,pageSize));
        return content.map(TransactionResponse::fromEntity);
    }

}
