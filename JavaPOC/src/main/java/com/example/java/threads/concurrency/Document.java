/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.threads.concurrency;

public class Document implements Comparable<Document> {

    private int docId;
    private String docName;

    public Document(int bookId, String bookName) {
        this.docId = bookId;
        this.docName = bookName;
    }

    public int getDocId() {
        return docId;
    }

    public String getDocName() {
        return docName;
    }

    @Override
    public int compareTo(Document ob) {
        return docName.compareTo(ob.getDocName());
    }
}
