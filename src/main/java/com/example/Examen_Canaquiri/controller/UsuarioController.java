/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Examen_Canaquiri.controller;
import com.example.Examen_Canaquiri.model.Usuario;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author FLOMAR
 */
@Controller
public class UsuarioController {
    @GetMapping("/login")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    // Ruta para procesar el formulario de login
    @PostMapping("/login")
    public String procesarLogin(Usuario usuario, Model model) {
        if ("admin".equals(usuario.getNombreUsuario()) && "admin".equals(usuario.getContrasena())) {
            model.addAttribute("mensaje", "¡Login exitoso! Has ingresado correctamente.");
            return "exito";
        } else {
            model.addAttribute("error", "Credenciales incorrectas. Intenta de nuevo.");
            return "login";
        }
    }
}
