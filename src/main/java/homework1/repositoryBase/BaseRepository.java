package homework1.repositoryBase;

import java.util.List;

public interface BaseRepository <T, I>{
    T create(T t);
    List<T> readAll();
    T update(T t);
    void deleteByUd(I id);
}
