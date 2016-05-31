package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.VideoMemory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class VideoMemoryDao {

    @PersistenceContext
    private EntityManager manager;

    public VideoMemoryDao() {
    }

    public void saveVideo(VideoMemory video) {
        manager.persist(video);
    }

    public VideoMemory findVideo(int idVideo) {
        return manager.find(VideoMemory.class, idVideo);
    }

    public VideoMemory removeVideo(int idVideo) {
        VideoMemory video = manager.find(VideoMemory.class, idVideo);
        manager.remove(video);
        return video;
    }

    public List getAll() {
        return manager.createQuery("SELECT m FROM Videomemory m").getResultList();
    }

    public void updateVideo(VideoMemory video) {

        VideoMemory videoFromDB = manager.find(VideoMemory.class, video.getId());

        if (videoFromDB == null) return;

        videoFromDB.setMemoryInGb(video.getMemoryInGb());
        videoFromDB.setManufacturer(video.getManufacturer());

        manager.merge(videoFromDB);

    }
}
