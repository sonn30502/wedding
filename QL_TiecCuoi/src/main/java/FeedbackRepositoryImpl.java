
import com.dcs.pojos.Feedback;
import com.dcs.repository.FeedbackRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class FeedbackRepositoryImpl implements FeedbackRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void updateFeedback(Feedback feedback) {
        Session session = this.factory.getObject().getCurrentSession();
        if (feedback.getFeedbackID() == null) {
            session.save(feedback);
        } else {
            session.update(feedback);
        }
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        Session session = this.factory.getObject().getCurrentSession();
        Query<Feedback> query = session.createQuery("FROM Feedback", Feedback.class);
        List<Feedback> feedbacks = query.getResultList();
        return feedbacks;
    }

}
