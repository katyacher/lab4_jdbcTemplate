package ru.myApp;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
	/** Минимальное значение целого числа для работы с меню*/
	private static final int MIN_INT = 0;
	/** Максимальное значение целого числа для работы с меню*/
    private static final int MAX_INT = 6;
    
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(SpringConfig.class);
		
		JewelDao jewelDao = context.getBean("jewelDao", JewelDao.class);
		
		String s= "";
		int answer = 0;
		
		while( !"6".equals(s)){
        	System.out.println("");
            System.out.println("Выберете действие:");
            System.out.println("1. Добавить новую запись в БД "); 
            System.out.println("2. Вывести все записи из таблицы БД в консоль");
            System.out.println("3. Редактировать запись БД по id");
            System.out.println("4. Удалить запись из БД по  id");
            System.out.println("5. Искать все украшения со стоимостью до определенной суммы (включительно)");
            System.out.println("6. Завершение работы приложения.");
            
            s = scanner.next(); 
            
            try {
            	answer = Integer.parseInt(s);
            	
            	if(answer > MIN_INT && answer <= MAX_INT){
                    switch (answer) {
                        case 1:
                        	int id, size, price;
                        	String type, metal, stone;
                        	System.out.println("Введите следующие параметры:");
                        	System.out.println("---индекс:");
                        	id = scanner.nextInt(); 
                        	System.out.println("---размер:");
                        	size = scanner.nextInt();
                        	System.out.println("---цена:");
                        	price = scanner.nextInt(); 
                        	System.out.println("---тип украшения:");
                        	type = scanner.next();
                        	System.out.println("---метал:");
                        	metal = scanner.next();
                        	System.out.println("---вставка из камня:");
                        	stone = scanner.next();
                        	
                        	Jewel item = new Jewel(id, size, price, type, metal, stone);
                        	
                    		if(jewelDao.insert(item) == 1) {
                    			System.out.println("Запись добавлена в БД");
                    		} 
                            break;
                        case 2:
                        	List<Jewel> jewelry = jewelDao.findAll();
                    		for(Jewel jewel: jewelry) {
                    			System.out.println(jewel.toString());
                    		}
                            break;
                        case 3:
                        	System.out.println("Введите id:");
                        	id = scanner.nextInt(); 
                        	
                        	
                    		for(Jewel jewel: jewelDao.findAll()) {
                    			if(jewel.getId() == id) {
                    				System.out.println("Введите новые параметры:");
                                	System.out.println("---размер:");
                                	size = scanner.nextInt();
                                	jewel.setSize(size);
                                	System.out.println("---цена:");
                                	price = scanner.nextInt(); 
                                	jewel.setPrice(price);
                                	System.out.println("---тип украшения:");
                                	type = scanner.next();
                                	jewel.setType(type);
                                	System.out.println("---метал:");
                                	metal = scanner.next();
                                	jewel.setMetal(metal);
                                	System.out.println("---вставка из камня:");
                                	stone = scanner.next();
                                	jewel.setStone(stone);
                            		jewelDao.update(id, jewel);
                    			};
                    		}
                    		
                            break;
                        case 4:
                        	System.out.println("Введите id:");
                        	id = scanner.nextInt(); 
                        	
                        	jewelDao.delete(id);
                            break;
                        case 5:
                        	System.out.println("Введите максимальную цену:");
                        	 price = scanner.nextInt(); 
                        	List<Jewel> jewelUpTo = jewelDao.searchUpTo(price);
                        	for(Jewel jewel: jewelUpTo) {
                    			System.out.println(jewel.toString());
                    		}
                        	
                        	 break;
                        case 6:
                        	System.out.println("Exit");
                            scanner.close();
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("Некорректный диапазон, попробуйте снова!");
                    answer = 0;
                }
            	
            }catch ( NumberFormatException e) {
            	System.out.println("Необходимо ввести число от 1 до 6.");
            };
            
        }
		
		context.close();
	}

}

