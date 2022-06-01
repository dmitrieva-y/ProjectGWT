package com.example.gwt_project.client;

import com.example.gwt_project.server.GwtServiceIntf;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.List;


public class ClientModule implements EntryPoint {


    VerticalPanel dialogVPanel = new VerticalPanel();

//
//   private final GwtServiceIntf gwtAppService = GWT.create(GwtServiceIntf.class);
//
////    /** This is the entry point method.*/
//    public void onModuleLoad() {
//
//        Label usernameLabel = new Label();
//        usernameLabel.setText("Username: ");
//        RootPanel.get("helloId").add(helloLabel);


    //}

    static class Book {
        String name;
        String author;

        public Book(String name, String author) {
            this.name = name;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    List<Book> books = new ArrayList<>();

    private HTMLPanel makeTable(List<Book> books) {
        RootPanel.get().clear();
        HTMLPanel tableContainer = new HTMLPanel("");
        FlexTable table = new FlexTable();
        Button openPreview;
        // openPreview.addClickHandler(clickEvent -> bookToPreview = book);

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            openPreview = new Button("Preview");
            table.setText(i, 0, book.name);
            table.setText(i, 1, book.author);
            table.setWidget(i, 2, openPreview);
            openPreview.addClickHandler(clickEvent -> previewBook(book));
            tableContainer.add(table);
        }

        Button button = new Button("Shelve");
        tableContainer.add(button);
        button.addClickHandler(clickEvent -> showForm());
        return tableContainer;
    }

    private void showForm() {
        RootPanel.get().clear();
        HTMLPanel panel = new HTMLPanel("");
        InlineLabel inlineLabel1 = new InlineLabel("One");
        InlineLabel inlineLabel2 = new InlineLabel("Two");
        Label label = new Label("Three");
        panel.add(inlineLabel1);
        panel.add(inlineLabel2);
        panel.add(label);
        Button back = new Button("Back");
        back.addClickHandler(clickEvent ->  RootPanel.get().add(makeTable(books)));
        panel.add(back);
        RootPanel.get().add(panel);
    }


    private void previewBook(Book book) {
        RootPanel.get().clear();
        HTMLPanel panel = new HTMLPanel("");
        Label nameLabel = new Label(book.name);
        Label authorLabel = new Label(book.author);
        Button back = new Button("Back");
        back.addClickHandler(clickEvent ->  RootPanel.get().add(makeTable(books)));
        panel.add(nameLabel);
        panel.add(authorLabel);
        panel.add(back);

        RootPanel.get().add(panel);
    }

    @Override
    public void onModuleLoad() {
        Book book = new Book("name", "author");
        Book book1 = new Book("name1", "author1");
        Book book2 = new Book("name2", "author3");
        books.add(book);
        books.add(book1);
        books.add(book2);
        RootPanel.get().add(makeTable(books));



/*        Label label = new Label("text");
        label.addStyleName("bold");
        Button button = new Button("ClickMe");
        button.addClickHandler(clickEvent -> Window.alert("Clicked"));
        PushButton pb = new PushButton("Jump", "Jump?", (ClickHandler) clickEvent -> Window.alert("Way"));
        CheckBox checkBox = new CheckBox("slf");
        checkBox.setValue(true);
        checkBox.addClickHandler(clickEvent -> {
            boolean ch =((CheckBox) clickEvent.getSource()).getValue();
            Window.alert("It is " + ch);
        });
        RootPanel.get().add(label);
        RootPanel.get().add(button);
        RootPanel.get().add(pb);
        RootPanel.get().add(checkBox);*/

    }
}
