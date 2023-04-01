package com.example.demo.controlador;

import com.example.demo.modelo.ProductoRepositorio;
import com.example.demo.modelo.producto;
import com.example.demo.vista.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoControlador implements ActionListener {

    ProductoRepositorio productoRepositorio;
    vista Vista;

    public ProductoControlador(ProductoRepositorio productoRepositorio, vista Vista) {
        this.productoRepositorio = productoRepositorio;
        this.Vista = Vista;
        manejadorEventos();

    }

    private void manejadorEventos() {
        Vista.getBtnAgregar_producto().addActionListener(this);
        Vista.getBtnActualizar_producto().addActionListener(this);
        Vista.getBtnBorrar_producto().addActionListener(this);
        Vista.getBtn_Informe().addActionListener(this);
    }

    public void buscarProductos() {

    }

    public void agregar() {
        String nombre = Vista.getTxtNombre().getText();
        Integer inventario = Integer.parseInt(Vista.getTxtInventario().getText());
        Double precio = Double.parseDouble(Vista.getTxtPrecio().getText());

        producto Producto = new producto(null, nombre, precio, inventario);

        productoRepositorio.save(Producto);
        JOptionPane.showMessageDialog(null, "Producto creado correctamente", "CREADO", JOptionPane.INFORMATION_MESSAGE);

    }

    public void actualizar() {

    }

    public void eliminar() {

    }

    public void generarInforme() {

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == Vista.getBtnAgregar_producto()) {
            if (Vista.getTxtNombre().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del producto");
            } else if (Vista.getTxtPrecio().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el precio del producto");
            } else if (Vista.getTxtInventario().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el inventario del producto");
            } else {
                agregar();
                Vista.getTxtNombre().setText("");
                Vista.getTxtInventario().setText("");
                Vista.getTxtPrecio().setText("");
            }

        }

    }

}
