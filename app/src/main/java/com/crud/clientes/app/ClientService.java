import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    // 1. Busca paginada
    @Transactional(readOnly = true)
    public Page<Client> findAllPaged(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // 2. Busca por id
    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado")); // Lança exceção para o 404
    }

    // 3. Inserir novo recurso
    @Transactional
    public Client insert(Client client) {
        return repository.save(client);
    }

    // 4. Atualizar recurso
    @Transactional
    public Client update(Long id, Client clientData) {
        // Verifica se existe para lançar a exceção do 404 caso não encontre
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado");
        }

        clientData.setId(id); // Garante que estamos a atualizar o ID correto
        return repository.save(clientData);
    }

    // 5. Deletar recurso
    @Transactional
    public void delete(Long id) {
        // Verifica se existe para lançar a exceção do 404 caso não encontre
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado");
        }
        repository.deleteById(id);
    }
}