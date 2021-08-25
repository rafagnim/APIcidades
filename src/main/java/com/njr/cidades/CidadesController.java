package com.njr.cidades;

import com.njr.cidades.entities.Cidade;
import com.njr.cidades.entities.Estado;
import com.njr.cidades.entities.Pais;
import com.njr.cidades.services.AcessoDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class CidadesController {
    private final AcessoDB acessoDB;

    public CidadesController(AcessoDB acessoDB) {
        this.acessoDB = acessoDB;
    }

    @GetMapping("/paises")
    public List<Pais> paises() {
        return acessoDB.listaCompletaPaises();
    }
    @GetMapping("/paisesAlfabetico")
    public Set<Pais> paisesAlfabetico() {
        return acessoDB.listaCompletaPaisesOrdemAlfabetica();
    }
    @GetMapping("/estados")
    public List<Estado> estados() {
        return acessoDB.listaCompletaEstados();
    }
    @GetMapping("/estadosAlfabetico")
    public Set<Estado> estadosAlfabetico() {
        return acessoDB.listaCompletaEstadosOrdemAlfabetica();
    }

    @GetMapping("/cidades")
    public List<Cidade> cidades() {
        return acessoDB.listaCompletaCidades();
    }

    @GetMapping("/cidades/{id}")
    public Cidade cidadeId(@PathVariable Long id) {
        return acessoDB.cidadeId(id);
    }

    // lista cidades por filtro da aplicação
    @GetMapping("/nomecidade/{nomeCidade}")
    public List<Cidade> cidadesPorNome(@PathVariable String nomeCidade) {
        return acessoDB.listaCidadePorNome(nomeCidade);
    }

    // lista cidades por filtro do Banco de Dados Postgree - Query
    @GetMapping("/nomecidadeDB/{nomeCidade}")
    public List<Cidade> cidadesPorNomeDB(@PathVariable String nomeCidade) {
        return acessoDB.listaCidadePorNome(nomeCidade);
    }

    // Pesquisar assim: http://localhost:8080/distancia?de=9999&ate=9999
    //                                   porta              id1      id2

    @GetMapping("/distancia")
    public Double emQuilometros(@RequestParam(name = "de") final Long cidade1,
                         @RequestParam(name = "ate") final Long cidade2) {
        return acessoDB.distanciaEntreCidades(cidade1, cidade2);
    }
}
