package frontend.listeners;

import frontend.components.TextFields;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AppMenuListeners {

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    ClipboardOwner clipboardOwner = new ClipboardOwner() {
        @Override
        public void lostOwnership(Clipboard clipboard, Transferable transferable) {
            clipboardOwner.lostOwnership(clipboard, currentContent);
        }
    };
    Transferable currentContent = clipboard.getContents(null);
    Transferable contents;
    String clipboardContent = "";

    public ActionListener copyListener = e -> {
        copy();
    };

    public void copy() {
        Transferable text = new StringSelection(TextFields.resultField.getText());
        clipboard.setContents(text, null);
    }

    public void copy(String str) {
        Transferable text = new StringSelection(str);
        clipboard.setContents(text, null);
    }

    public String paste() {
        contents = clipboard.getContents(null);
        try {
            clipboardContent = (String) contents.getTransferData(DataFlavor.stringFlavor);
        }
        catch (UnsupportedFlavorException | IOException ex){
            System.out.println(ex);
            ex.printStackTrace();
        }
        return clipboardContent;
    }

}
