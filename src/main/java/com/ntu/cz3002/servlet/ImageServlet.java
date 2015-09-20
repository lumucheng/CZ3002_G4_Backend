/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntu.cz3002.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mucheng
 */
public class ImageServlet extends HttpServlet {

    private static final String PATH_DIRECTORY = "/etc/images/";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String queryString = request.getPathInfo();
        String path = PATH_DIRECTORY + queryString;

        ServletOutputStream out;
        out = response.getOutputStream();
        FileInputStream fin = new FileInputStream(path);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int ch = 0;
        while ((ch = bin.read()) != -1) {
            bout.write(ch);
        }

        bin.close();
        fin.close();
        bout.close();
        out.close();
    }
}
