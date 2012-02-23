package mike.utils.jsimpletext.component;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import javax.swing.JTextField;
import mike.utils.jsimpletext.exceptions.SimpleTextException;

/**
 * JSimpleTextField.java
 * Created on 19/02/2012, 18:53:19
 * 
 * @author Miguel Augusto Caligares
 * @email mcaligares@gmail.com
 * @version 0.1
 */
public class JSimpleTextField extends JTextField implements KeyListener{
    private static final long serialVersionUID = 1505256564256217821L;
    public static final String PROPERTY_FIELD_NAME = "fieldName";
    public static final String PROPERTY_LENGTH = "length";
    public static final String PROPERTY_STATE = "state";
    
    protected String fieldName;
    protected boolean state;
    protected Color color;
    protected int length;

    public JSimpleTextField() {
        this(10,"SimpleText field",true);
    }
    public JSimpleTextField(String fieldName, boolean state) {
        this(10,fieldName,true);
    }
    public JSimpleTextField(int length, String fieldName) {
        this(length,fieldName,true);
    }
    @SuppressWarnings("LeakingThisInConstructor")
    public JSimpleTextField(int length, String fieldName, boolean state) {
        this.state = state;
        this.length = length;
        this.fieldName = fieldName;
        this.color = getForeground();
        if(!state) setForeground(Color.RED);
        addKeyListener(this);
    }

    public int getLength() {return length;}
    public String getFieldName() {return fieldName;}
    public boolean isState() {return state;}
    
    public void setLength(int newValue) {
        int oldValue = length;
        length = newValue;
        if(getText().length()>length)
            setState(false);
        else
            setState(true);
        super.firePropertyChange(PROPERTY_LENGTH, oldValue, newValue);
    }
    public void setFieldName(String newValue) {
        String oldValue = this.fieldName;
        this.fieldName = newValue;
        super.firePropertyChange(PROPERTY_FIELD_NAME, oldValue, newValue);
    }
    public void setState(boolean newValue) {
        boolean oldValue = state;
        state = newValue;
        if(!state)
            setForeground(Color.RED);
        else
            setForeground(color);
        super.firePropertyChange(PROPERTY_STATE, oldValue, newValue);
    }
    
    public String getString() throws SimpleTextException {
        if(state)
            if(getText().length()<=length)
                return getText();
        throw new SimpleTextException(fieldName);
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if(getText().length()>length) {
            state = false;
            setForeground(Color.RED);
        }
        else {
            state = true;
            setForeground(color);
        }
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
         super.addPropertyChangeListener(listener);
     }
    @Override
     public void removePropertyChangeListener(PropertyChangeListener listener) {
         super.removePropertyChangeListener(listener);
     }
}
