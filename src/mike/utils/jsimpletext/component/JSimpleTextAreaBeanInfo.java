package mike.utils.jsimpletext.component;

import java.beans.BeanDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * JSimpleTextAreaBeanInfo.java
 * Created on 06/03/2012, 18:33:47
 * 
 * @author Miguel Augusto Caligares
 * @email mcaligares@gmail.com
 */
public class JSimpleTextAreaBeanInfo extends SimpleBeanInfo{
    private static final String FILE = "/mike/utils/jsimpletext/resources/JSimpleTextFieldIcon%s.gif";
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor bd = new BeanDescriptor(JSimpleTextField.class, null);
        bd.setDisplayName("Simple Text Area");
        bd.setShortDescription("A lightweight component that allow the editing of a simple line of a length determined.");
        return bd;
    }
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_MONO_16x16: return loadImage(String.format(FILE, "Mono16"));
            case ICON_MONO_32x32: return loadImage(String.format(FILE, "Mono32"));
            case ICON_COLOR_16x16:  return loadImage(String.format(FILE, "Color16"));
            case ICON_COLOR_32x32: return loadImage(String.format(FILE, "Color32"));
            default: return null;
        }
    }
}
