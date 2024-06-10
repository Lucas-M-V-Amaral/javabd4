package com.aulabd2.aulabd2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aulabd2.aulabd2.model.Conta;
import com.aulabd2.aulabd2.model.ContaService;

@Controller
public class IndexController {

    @Autowired
	private ApplicationContext context;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/faq")
    public String faq(){
        return "faq";
    }

    @GetMapping("/contato")
    public String contato(){
        return "contato";
    }

    @GetMapping("/avaliacoes")
    public String avaliacoes(){
        return "avaliacoes";
    }

    @GetMapping("/contas")
    public String contas(){
        return "contas_lista";
    }



    @GetMapping("/anunciar")
    public String anunciar(Model model){
        model.addAttribute("conta",new Conta());
        return "contas";
    }

    @PostMapping("/anunciar")
    public String anunciar(Model model, @ModelAttribute Conta conta){
        ContaService cs = context.getBean(ContaService.class);
		cs.inserirConta(conta);
		return "index";
    }

    @GetMapping("/anuncios")
    public String listarAnuncios(Model model){
        ContaService cs = context.getBean(ContaService.class);
        List<Map<String,Object>> lista = cs.listarContas();
        model.addAttribute("lista",lista);
        return "contas_lista";
    }

    @GetMapping("/atualizar_anuncio/{id}")
    public String atualizar(@PathVariable("id") int id, Model model){
        ContaService cs = context.getBean(ContaService.class);
        Map<String,Object> conta = cs.obterConta(id).get(0);
        String add1 = (String) conta.get("add1");
        String add2 = (String) conta.get("add2");
        model.addAttribute("conta", new Conta(add1,add2));
        model.addAttribute("add1", add1);
        model.addAttribute("add2", add2);
        return "atualizar_anuncio";
    }

    @PostMapping("/atualizar_anuncio/{id}")
    public String atualizar(@PathVariable("id") int id
        , Model model
        , @ModelAttribute Conta conta){
            ContaService cs = context.getBean(ContaService.class);
            cs.atualizarConta(id, conta);
            return "redirect:/contas_lista";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") int id){
        ContaService cs = context.getBean(ContaService.class);
        cs.apagarConta(id);
        return "redirect:/contas_lista";
    }

    // @GetMapping("/anunciar")
    // public String anunciar(Model model){
    //     model.addAttribute("conta",new Conta());
    //     return "contas";
    // }

    // @PostMapping("/anunciar")
    // public String anunciar(Model model, @ModelAttribute Conta conta){
    //     ContaService cs = context.getBean(ContaService.class);
	// 	cs.inserirConta(conta);
	// 	return "index";
    // }

    // @GetMapping("/listar")
    // public String listar(Model model){
    //     ContaService cs = context.getBean(ContaService.class);
    //     List<Map<String,Object>> lista = cs.listarContas();
    //     model.addAttribute("lista",lista);
    //     return "contas_lista";
    // }

    // @GetMapping("/atualizar_anuncio/{id}")
    // public String atualizarAnuncio(@PathVariable("id") int id, Model model){
    //     ContaService cs = context.getBean(ContaService.class);
    //     Map<String,Object> conta = cs.obterConta(id).get(0);
    //     String add1 = (String) conta.get("add1");
    //     String add2 = (String) conta.get("add2");
    //     model.addAttribute("conta", new Conta(add1,add2));
    //     model.addAttribute("add1", add1);
    //     model.addAttribute("add2", add2);
    //     return "atualizar_anuncio";
    // }

    // @PostMapping("/atualizar/{id}")
    // public String atualizar(@PathVariable("id") int id
    //     , Model model
    //     , @ModelAttribute Conta conta){
    //         ContaService cs = context.getBean(ContaService.class);
    //         cs.atualizarConta(id, conta);
    //         return "redirect:/contas_lista";
    // }

    // @PostMapping("/deletar/{id}")
    // public String deletar(@PathVariable("id") int id){
    //     ContaService cs = context.getBean(ContaService.class);
    //     cs.apagarConta(id);
    //     return "redirect:/contas_lista";
    // }

}
