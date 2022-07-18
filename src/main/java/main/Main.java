package main;

import java.sql.Connection;
import java.util.Scanner;
import dao.QuestionDao;
import model.Question;
public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		QuestionDao questionDao = new QuestionDao();
		String name;
		
		char operationType;
		int updateQuestion;
		
		Question questionAdd = new Question();
		
		String questionName ;
		String option1,option2,option3,option4;
		String answerCorr;
		
		Question questionUpdate = new Question();
		char choise;
		
		int id ;
		
		System.out.println("****** KickIt CTB Quiz App ******");
		System.out.println("Enter your Name: ");
		name = reader.nextLine();
		System.out.println("Hi there, " + name + "!");

		do {
			System.out.println("1-Update the Quiz. \n2-Start Quiz.\n0-Exit.");
			System.out.print("Enter type of the operation: ");
			operationType = reader.next().charAt(0);

			if (operationType == '0') {
				System.out.println("Exit!");
				reader.close();
				break; 
			} else if (operationType == '1') {
				System.out.println("1-View the Questions .\n2-Add a Question. \n3-Update a Question. \n4-Delete a Question. \n0-Exit. \n");
				System.out.print("Enter type of the operation: ");
				updateQuestion = reader.next().charAt(0);
				if(updateQuestion =='1') {
					for (Question question : questionDao.getAll()) {
						System.out.println("\n\nQuestion "+question.getId()+":"+question.getQuestion());
						System.out.println("1-"+question.getOption1()+"\n2-"+question.getOption2()+"\n3-"+question.getOption3()+"\n4-"+question.getOption4()+"\n\n");
						
					}
				}
				else if(updateQuestion =='2') {
					System.out.print("Enter the question : ");
					questionName = reader.next();
					System.out.print("Enter the 1st option : ");
					option1 = reader.next();
					System.out.print("Enter the 2nd option : ");
					option2 = reader.next();
					System.out.print("Enter the 3rd option : ");
					option3 = reader.next();
					System.out.print("Enter the 4th option : ");
					option4 = reader.next();
					System.out.print("Enter the nbr of the answer : ");
					answerCorr = reader.next();
					questionAdd = new Question(questionName,option1,option2,option3,option4,answerCorr);
					
					if(questionDao.insert(questionAdd)==true)
					{
						System.out.println("The insert is done . ");
					}
					else
					{
						System.out.println("Errur in the insert . ");
					}
					
				}
				else if(updateQuestion =='3') {
					System.out.print("Enter the id of the question that you want to update : ");
					id=reader.nextInt();
					if (questionUpdate == questionDao.getOne(id))
					{
					
						System.out.println("you want to update 1-The question. \n2-The 1st option. \n3-The 2nd option. \n4-The 3rd option. \n5-The 4th option. \n6-The answer.\n0-Exit.");
						System.out.print("Enter type of the operation: ");
						choise = reader.next().charAt(0);
						do {
							if (choise == '1') {
								System.out.print("Enter the question : ");
								questionName = reader.next();
								questionUpdate.setQuestion(questionName);
								if(questionDao.update(id,questionAdd)==true)
								{
									System.out.println("The update is done . ");
								}
								else
								{
									System.out.println("Errur in the update . ");
								}
								
							}
							else if (choise == '2') {
								System.out.print("Enter the 1st option : ");
								option1 = reader.next();
								questionUpdate.setOption1(option1);
								if(questionDao.update(id,questionUpdate)==true)
								{
									System.out.println("The update is done . ");
								}
								else
								{
									System.out.println("Errur in the update . ");
								}
								
							}
							else if (choise == '3') {
								System.out.print("Enter the 2nd option : ");
								option2 = reader.next();
								questionUpdate.setOption2(option2);
								if(questionDao.update(id,questionUpdate)==true)
								{
									System.out.println("The update is done . ");
								}
								else
								{
									System.out.println("Errur in the update . ");
								}
								
							}
							else if (choise == '4') {
								System.out.print("Enter the 3rd option : ");
								option3 = reader.next();
								questionUpdate.setOption3(option3);
								if(questionDao.update(id,questionUpdate)==true)
								{
									System.out.println("The update is done . ");
								}
								else
								{
									System.out.println("Errur in the update . ");
								}
								
							}else if (choise == '5') {
								System.out.print("Enter the 4th option : ");
								option4 = reader.next();
								questionUpdate.setOption4(option4);
								if(questionDao.update(id,questionUpdate)==true)
								{
									System.out.println("The update is done . ");
								}
								else
								{
									System.out.println("Errur in the update . ");
								}
								
							}
							else if (choise == '5') {
								System.out.print("Enter the nbr of the answer : ");
								answerCorr = reader.next();
								questionUpdate.setAnswer(answerCorr);
								if(questionDao.update(id,questionUpdate)==true)
								{
									System.out.println("The update is done . ");
								}
								else
								{
									System.out.println("Errur in the update . ");
								}
							}
							else if(choise =='0') {
								System.out.println("Exit!");
								break; 
							}
								
						}while(choise>6);
						
					}
					else
					{
						System.out.println("The question doesn't exist. ");
					}
				}
				else if(updateQuestion =='4') {
					System.out.print("Enter the id of the question that you want to delete : ");
					id=reader.nextInt();
					if (questionDao.delete(id)==true)
					{
						System.out.println("The delete is done . ");
					}
					else
					{
						System.out.println("Errur in the delete .");
					}
				}
				else if(updateQuestion =='0') {
					System.out.println("Exit!");
					reader.close();
					break; 
				}
				
				
				
				
			
			} else if (operationType == '2') { // Start Quiz

				int i = 0;
				for (Question question : questionDao.getAll()) {
					System.out.println("\n\nQuestion "+question.getId()+":"+question.getQuestion());
					System.out.println("1-"+question.getOption1()+"\n2-"+question.getOption2()+"\n3-"+question.getOption3()+"\n4-"+question.getOption4());
					System.out.print("Your Answer is:");
					char answer = reader.next().charAt(0);
					if(answer == question.getAnswer().charAt(0)) {
						System.out.println("\n==========> Correct!");
						i++;
					}else {
						System.out.println("\n==========> InCorrect!");
					}
					
				}
				System.out.println("you have "+i +"correct answers");
				System.out.println("\n\n[http://localhost:8888/kickit-ctb/Question?count="+questionDao.getAll().size()+"&name="+name+"]\n\n");
			
	        } else {
				System.out.println("Error opertaion doesnt exist!");
				continue;
			}

		} while (true);

		reader.close();       
	}

}
