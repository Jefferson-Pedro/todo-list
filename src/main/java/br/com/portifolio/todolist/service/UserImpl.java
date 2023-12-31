package br.com.portifolio.todolist.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.portifolio.todolist.dao.IUserDAO;
import br.com.portifolio.todolist.model.User;

@Component
public class UserImpl implements IUserService{
	
	@Autowired
	private IUserDAO dao;

	@Override
	public User save(User novo) {
		if(novo != null) {			
			novo.setPassword(BCrypt.withDefaults()
				.hashToString(12, novo.getPassword()
				.toCharArray()));
			return dao.save(novo);
		}
		System.err.println("O objeto User está null");
		return null;
	}

	@Override
	public User update(User user, UUID id) {
		Optional<User> res = dao.findById(id);
	    if (res.isPresent()) {
	    	User existingUser = res.get();
	        BeanUtils.copyProperties(user, existingUser, "id");
	        return dao.save(existingUser);
	    }
	    System.out.println("Erro ao editar o usuário!");
		return null;
	}

	@Override
	public boolean delete(UUID id) {
		Optional<User> res = dao.findById(id);
	    if (res.isPresent()) {
	    	dao.deleteById(id);
	    	System.out.println("Usuário com id " + id + " excluido com sucesso!");
	    	return true;
	    }
	    System.err.println("Ocorreu um erro ao excluir o usuário " + id);
		return false;
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public User findById(UUID id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public User findByUserName(String userName) {
		return dao.findByUserName(userName);
	}
	
	// public Optional<User> findByUserName(String userName) {
	// 	  return dao.findByuserNameContaining(userName);
	// }

	

}
