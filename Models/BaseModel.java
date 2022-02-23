package Models;

import java.util.Vector;

public class BaseModel {

    private String title = null;
    private Vector<ModelChangedListener> listenerVector = new Vector<ModelChangedListener>();

    public BaseModel(String title) {
        this.title = title;
    }

    public String getTitle() { return this.title; }

    public void addModelChangedListener(ModelChangedListener listener){
        listenerVector.add(listener);
    }
    protected void notifyModelChangedListeners(Object source){
        for(ModelChangedListener listener: listenerVector) {
            listener.onModelChanged(source);
        }
    }
}
