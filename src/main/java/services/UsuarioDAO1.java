package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO1 {

    private final EntityManager entityManager;

    public UsuarioDAO1(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Usuario insert(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    public Usuario update(Usuario usuario) {
        entityManager.merge(usuario);//troca no banco
        entityManager.persist(usuario);
        return usuario;
    }

    public Usuario insertOrUpdate(Usuario usuario) {
        if (usuario.getId() > 0) {
            return this.update(usuario);
        }
        return this.insert(usuario);
    }

    public void delete(Usuario usuario) {
        entityManager.merge(usuario);
        entityManager.remove(usuario);
    }

    public Usuario selectPorId(Usuario usuario) {
        return entityManager.find(Usuario.class, usuario);
    }

    public List<Usuario> selectAll() {
        String jpql = "select u from Usuario as u";
        Query query = entityManager.createQuery(jpql);//jpql é uma linguagem de busca semelhante ao sql
 return retornarListaComBaseNaConsulta(query);
}

    private List<Usuario> retornarListaComBaseNaConsulta(Query query) {
        List<Usuario> usuarios;
        try {
            usuarios= query.getResultList();
            
        } catch (NoResultException e) {
            usuarios = new ArrayList<>();
        }
        return usuarios;
    }

    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) {
        String jpql = "select u from Usuario as u "
                + "where u.usuario = :pUsuario and u.senha=:pSenha";

        Query query = entityManager.createQuery(jpql);//jpql é uma linguagem de busca semelhante ao sql
       // query.setParameter("pUsuario", usuario.getUsuario());
        query.setParameter("pSenha", usuario.getSenha());
        return !retornarListaComBaseNaConsulta(query).isEmpty();
       
    }
}
