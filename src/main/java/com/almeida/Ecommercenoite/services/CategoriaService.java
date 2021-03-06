package com.almeida.Ecommercenoite.services;

import com.almeida.Ecommercenoite.exceptions.CategoriaAlreadyExistsException;
import com.almeida.Ecommercenoite.exceptions.UsernameTakenException;
import com.almeida.Ecommercenoite.models.CategoriaModel;
import com.almeida.Ecommercenoite.repositories.CategoriaRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Getter
@Setter
@Service
public class CategoriaService {

    public CategoriaService() {
    }

    @Autowired
    public CategoriaRepository categoriaRepository;

    public CategoriaModel updateCategoria(CategoriaModel categoriaModel) {
        return categoriaRepository.save(categoriaModel);
    }

    public CategoriaModel createCategoria(CategoriaModel categoriaModel) {
        if (findCategoriaByNome(categoriaModel.getNome()).size() != 0) {
            throw new CategoriaAlreadyExistsException("Categoria ja cadastrada!");
        }
        return categoriaRepository.save(categoriaModel);
    }

    public List<CategoriaModel> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<CategoriaModel> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public void deleteCategoriaById(Long id) {
        categoriaRepository.deleteById(id);
    }

    public List<CategoriaModel> findCategoriaByNome(String nome) {
        return categoriaRepository.findCategoriaByNomeContains(nome.toUpperCase(Locale.ROOT));
    }
}
