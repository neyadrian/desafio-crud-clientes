import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients") // Rota base definida no teste do Postman
public class ClientController {

    @Autowired
    private ClientService service;

    // 1. Busca paginada
    @GetMapping
    public ResponseEntity<Page<Client>> findAll(Pageable pageable) {
        Page<Client> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    // 2. Busca por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

    // 3. Inserir novo recurso
    @PostMapping
    public ResponseEntity<Client> insert(@Valid @RequestBody Client client) {
        client = service.insert(client);
        // Boa prática REST: retornar código 201 Created com a URI do novo recurso
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    // 4. Atualizar recurso
    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @Valid @RequestBody Client client) {
        client = service.update(id, client);
        return ResponseEntity.ok().body(client);
    }

    // 5. Deletar recurso
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}