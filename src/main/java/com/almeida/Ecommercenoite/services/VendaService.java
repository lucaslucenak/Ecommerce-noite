package com.almeida.Ecommercenoite.services;

import com.almeida.Ecommercenoite.models.UsuarioModel;
import com.almeida.Ecommercenoite.models.VendaModel;
import com.almeida.Ecommercenoite.repositories.UsuarioRepository;
import com.almeida.Ecommercenoite.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Service
public class VendaService {
    public VendaService() {
    }

    @Autowired
    public VendaRepository vendaRepository;

    public VendaModel updateVenda(VendaModel vendaModel) {
        return vendaRepository.save(vendaModel);
    }

    public VendaModel createVenda(VendaModel vendaModel) {
        return vendaRepository.save(vendaModel);
    }

    public List<VendaModel> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Optional<VendaModel> getVendaById(Long id) {
        return vendaRepository.findById(id);
    }

    public void deleteVendaById(Long id) {
        vendaRepository.deleteById(id);
    }

    public List<VendaModel> findVendaByIdCliente (Long idCliente) {
        return  vendaRepository.findVendaByIdCliente(idCliente);
    }

    public void setEnvioStatus(Long id, Boolean status) {
        getVendaById(id).stream().filter(venda -> Objects.equals(venda.getId(), id)).forEach(venda -> {
            venda.setFoiEnviado(status);
        });
    }

}
