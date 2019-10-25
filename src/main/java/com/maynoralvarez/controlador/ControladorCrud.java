package com.maynoralvarez.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maynoralvarez.dto.ErrorDTO;
import com.maynoralvarez.modelo.Usuario;
import com.maynoralvarez.modelo.UsuarioCrud;

@RestController
@RequestMapping("/crud")
public class ControladorCrud {

	private UsuarioCrud uc;
	
	public ControladorCrud(UsuarioCrud uc) {
		this.uc = uc;
	}
	
	@GetMapping
	public List<Usuario> listaUsuarios() {
		return uc.findAll();
	}
	
	@GetMapping("/detail")
	public ResponseEntity nuevo(@RequestParam("id") Long id) {
		Optional<Usuario> usuario = this.uc.findById(id);
		if (usuario.isPresent()) {
			return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("NO se encontro entidad", HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity crear(@RequestBody Usuario usuario) {
		this.uc.save(usuario);
		return new ResponseEntity<>("Se guardo la entidad", HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity actualizar(@RequestBody Usuario usuario) {
		Optional<Usuario> vo =  this.uc.findById(usuario.getId());
		if(usuario.getId() != null && vo.isPresent()){
			this.uc.save(usuario);
			return new ResponseEntity <>("Se actualizo la entidad", HttpStatus.OK);
		}else {
			return  new ResponseEntity<>("No se Encontro la entidad",HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/borrar")
	public ResponseEntity borrar(@RequestParam("id") long id) {
		Optional<Usuario> usuario = this.uc.findById(id);
		if(usuario.isPresent()) {
			this.uc.deleteById(id);
			return new ResponseEntity<>("Entidad eliminada",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("no se encontro la Entidad",HttpStatus.CONFLICT);
		}
	}
	
}
