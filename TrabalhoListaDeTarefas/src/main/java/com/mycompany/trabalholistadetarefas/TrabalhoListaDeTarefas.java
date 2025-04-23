/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalholistadetarefas;

import com.mycompany.TrabalhoListaDeTarefas.database.ConnectSQL;
import com.mycompany.trabalholistadetarefas.view.Focus;
import com.mycompany.trabalholistadetarefas.view.Tasks;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class TrabalhoListaDeTarefas {

    public static void main(String[] args) {
        new Tasks().setVisible(true);
        ConnectSQL.connect();
    }
}
