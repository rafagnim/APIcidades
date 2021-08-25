package com.njr.cidades.services;

import com.njr.cidades.entities.Cidade;
import com.njr.cidades.entities.Estado;
import com.njr.cidades.entities.Pais;
import com.njr.cidades.repository.RepositoryCidade;
import com.njr.cidades.repository.RepositoryEstado;
import com.njr.cidades.repository.RepositoryPais;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Math.*;

@Service
public class AcessoDB {
    private final RepositoryPais repositoryPais;
    private final RepositoryEstado repositoryEstado;
    private final RepositoryCidade repositoryCidade;

    public AcessoDB(RepositoryPais repositoryPais, RepositoryEstado repositoryEstado, RepositoryCidade repositoryCidade){
        this.repositoryPais = repositoryPais;
        this.repositoryEstado = repositoryEstado;
        this.repositoryCidade = repositoryCidade;
    }

    public List<Pais> listaCompletaPaises() {
        return repositoryPais.findAll();
    }
    public Set<Pais> listaCompletaPaisesOrdemAlfabetica() {
        Set<Pais> listaAltabetica = new TreeSet<>();
        listaAltabetica.addAll(listaCompletaPaises());
        return listaAltabetica;
    }

    public List<Estado> listaCompletaEstados() {
        return repositoryEstado.findAll();
    }

    public Set<Estado> listaCompletaEstadosOrdemAlfabetica() {
        Set<Estado> listaAltabeticaEstados = new TreeSet<>();
        listaAltabeticaEstados.addAll(listaCompletaEstados());
        return listaAltabeticaEstados;
    }

    public List<Cidade> listaCompletaCidades() {
        return repositoryCidade.findAll();
    }

    public Cidade cidadeId(Long id) {
        Optional<Cidade> optional = repositoryCidade.findById(id);
        return optional.get();
    }

    //método utilizando a aplicação para fazer o filtro
    public List<Cidade> listaCidadePorNome(String c) {
        List<Cidade> listaCidades = new ArrayList<>();
        listaCidades.addAll(listaCompletaCidades());
        List<Cidade> listaFiltro = new ArrayList<>();
        for (Cidade tmp: listaCidades
             ) {
            if (tmp.getNome().toUpperCase().equals(c.toUpperCase())) {
                listaFiltro.add(tmp);
            }
        }
        return listaFiltro;
    }

    public List<Cidade> listaCidadePorNomeDB(String c) {
        return repositoryCidade.cidadesPorNomeDB(c);
    }

    public double distanciaEntreCidades (Long idCidade1, Long idCidade2) {
        Optional<Cidade> cidade1 = repositoryCidade.findById(idCidade1);
        Optional<Cidade> cidade2 = repositoryCidade.findById(idCidade2);
        double lat = toRadians(cidade2.get().getLatitude() - cidade1.get().getLatitude());
        double lon = toRadians(cidade2.get().getLongitude() - cidade2.get().getLongitude());
        double a = sin(lat / 2) * sin(lat / 2) +
                cos(toRadians(cidade1.get().getLatitude())) * cos(toRadians(cidade2.get().getLatitude())) * sin(lon / 2) * sin(lon / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        double raioTerraKm = 6378.168;
        return raioTerraKm * c;
    }
}
