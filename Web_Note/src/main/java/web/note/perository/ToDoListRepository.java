package web.note.perository;
import org.springframework.data.jpa.repository.JpaRepository;
import web.note.model.ToDoList;
import web.note.model.User;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

    void deleteByName(String name);

    ToDoList findByNameAndUser(String name, User user);

    ToDoList findByName(String toDoListName);

    ToDoList findByIdAndNameAndUser(Long id,String name,  User user);

//    ToDoList findFirstByUserAndCreateTime(User user);
}
