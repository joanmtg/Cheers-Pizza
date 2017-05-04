/**
 * Proyecto Desarrollo de Software II
 * Fecha de entrega: 19/04/2017
 * Universidad del Valle
 * EISC
 *
 * Integrantes: 
 *
 * Jhonier Andrés Calero Rodas		1424599
 * Fabio Andrés Castañeda Duarte	1424386
 * Juan Pablo Moreno Muñoz		1423437
 * Joan Manuel Tovar Guzmán		1423124
 *
 * file: ListaItems.java
 * 
 */


package Administracion;

import java.util.ArrayList;


/**
 *
 * @author Joan
 */
public class ListaItems implements Container{
    
    private Item[] items;
    
    public ListaItems(Item[] items){
        this.items = items;
    }
    
    @Override
    public Iterator getIterator() {        
        return new IteradorItems();
    }

    private class IteradorItems implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < items.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {                
                return items[index++];
            }
            return null;
        }
    }
}
