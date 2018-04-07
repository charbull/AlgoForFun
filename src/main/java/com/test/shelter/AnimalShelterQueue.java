package com.test.shelter;

import java.util.LinkedList;

public class AnimalShelterQueue {

	private LinkedList<Animal> shelterQueue = new LinkedList<Animal>();
	
	public void enqueue(Animal animal)
	{
		shelterQueue.addFirst(animal);
	}
	
	public Animal dequeueAny()
	{
		return shelterQueue.removeLast();
	}

	public Dog dequeueDog()
	{
		int currentIndex = shelterQueue.size()-1;
		
		while(currentIndex >0)
		{
			if(shelterQueue.get(currentIndex).getClass().isInstance(Dog.class))
			{
				return ((Dog)shelterQueue.remove(currentIndex));
			}
			currentIndex --;
		}
		return null;
	}
	
	public Cat dequeueCat()
	{
		int currentIndex = shelterQueue.size()-1;
		
		while(currentIndex >0)
		{
			if(shelterQueue.get(currentIndex).getClass().isInstance(Cat.class))
			{
				return ((Cat)shelterQueue.remove(currentIndex));
			}
			currentIndex --;
		}
		return null;
	}
	
}
