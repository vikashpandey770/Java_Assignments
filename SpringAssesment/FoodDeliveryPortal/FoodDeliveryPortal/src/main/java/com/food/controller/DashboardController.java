package com.food.controller;
import jakarta.servlet.http.HttpSession; import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.GetMapping;
@Controller public class DashboardController { @GetMapping("/dashboard") public String dashboard(HttpSession session){if(session.getAttribute("username")==null)return "redirect:/login"; return "dashboard";} }
