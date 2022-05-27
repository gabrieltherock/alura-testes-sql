package br.com.gabriel.leilao.dao;

import br.com.gabriel.leilao.model.Usuario;
import br.com.gabriel.leilao.util.JPAUtil;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UsuarioDaoTest {

    private UsuarioDao dao;

    @Test
    void testeBuscaUsuarioPeloUsername() {
        EntityManager em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);

        Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        Usuario encontrado = this.dao.buscarPorUsername(usuario.getNome());
        assertNotNull(encontrado);
    }
}
