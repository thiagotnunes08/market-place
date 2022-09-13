package br.com.zup.edu.marketplace.controller;


import br.com.zup.edu.marketplace.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DetalhaProdutosController {

    @Autowired
    private final ProdutoRepository repository;

    public DetalhaProdutosController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/produtos")
    public ResponseEntity<?> lista(@PageableDefault(size = 10,page = 0,sort = "id",direction = Sort.Direction.ASC)Pageable paginacao){



        Page<Produto> produtos = repository.findAll(paginacao);

        List<ProdutosResponse> produtosResponse = produtos.stream().map(ProdutosResponse::new).collect(Collectors.toList());

        PageImpl<ProdutosResponse> responses = new PageImpl<ProdutosResponse>(produtosResponse,paginacao,produtos.getTotalElements());


        return ResponseEntity.ok(responses);

    }

}
