package lab.cryptography.crypto.controllers;

import lab.cryptography.crypto.controllers.dto.request.CreateTransactionRequest;
import lab.cryptography.crypto.controllers.dto.request.UpdateTransactionRequest;
import lab.cryptography.crypto.controllers.dto.response.TransactionResponse;
import lab.cryptography.crypto.service.TransactionService;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {
    private final TransactionService service;
    private final ServerProperties serverProperties;


    public TransactionController(TransactionService service, ServerProperties serverProperties) {
        this.service = service;
        this.serverProperties = serverProperties;
    }

    @PostMapping
    public ResponseEntity<Void> create (@RequestBody CreateTransactionRequest request){
        service.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@PathVariable(value = "id") Long id,
                                        @RequestBody UpdateTransactionRequest request){

        service.update(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<TransactionResponse>> listAll (@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){
        var listResponse = service.listAll(page, pageSize);
        return ResponseEntity.ok(listResponse);
    }

    @GetMapping("/id")
    public ResponseEntity<TransactionResponse> findById(@PathVariable(value = "id") Long id){
        var findByIdResponse = service.findById(id);
        return ResponseEntity.ok(findByIdResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable(value = "id") Long id){

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
