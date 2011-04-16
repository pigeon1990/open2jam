package org.open2jam.render.entities;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author fox
 */
public class NumberEntity extends Entity
{
    int number = 0;
    int show_digits = 1;
    ArrayList<Entity> entity_list;
    
    public NumberEntity(Collection<Entity> list, double x, double y)
    {
        entity_list = new ArrayList<Entity>();
        entity_list.addAll(list);
        if(entity_list.size()>10) entity_list.remove(10);
        this.x = x;
        this.y = y;
        sprite = entity_list.get(0).sprite;
    }

    private NumberEntity(NumberEntity org) {
        super(org);
        entity_list = new ArrayList<Entity>();
        for(Entity e : org.entity_list)entity_list.add(e.copy());
        this.number = org.number;
    }

    public void setNumber(Integer i){
        this.number = i;
    }

    public int getNumber(){
        return number;
    }

    public void incNumber()
    {
        number++;
    }

    public void addNumber(int add)
    {
        number += add;
    }

    public void showDigits(int number)
    {
        show_digits = number;
    }

    @Override
    public void move(double delta)
    {
        super.move(delta);
    }
    
    @Override
    public void draw()
    {
        //draw from right to left
	String numberString = String.valueOf(number);
        if(numberString.length() < show_digits)
        {
            String zeros = "";
            for(int i = 1; i<show_digits;i++) zeros += "0";
            numberString = zeros+numberString;
        }
	String invNumberString = "";
        double tx = x;
	for(int j = numberString.length()-1; j >= 0; j--)
	{
	    invNumberString = invNumberString + numberString.charAt(j);
	}
	char[] chars = invNumberString.toCharArray();
        for(char c : chars)
        {
            int i = Integer.parseInt(c+"");
            tx -= entity_list.get(i).getWidth();
	    entity_list.get(i).setPos(tx,y);
            entity_list.get(i).draw();
        }
    }

    @Override
    public NumberEntity copy()
    {
        return new NumberEntity(this);
    }
}
