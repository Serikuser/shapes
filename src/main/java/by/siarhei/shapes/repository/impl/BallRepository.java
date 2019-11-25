package by.siarhei.shapes.repository.impl;

import by.siarhei.shapes.entity.impl.Ball;
import by.siarhei.shapes.repository.CompareType;
import by.siarhei.shapes.repository.api.BallSpecification;
import by.siarhei.shapes.repository.api.FiguresInMemoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class BallRepository implements FiguresInMemoryRepository {
    private static final Logger logger = LogManager.getLogger();
    private static BallRepository instance;
    private Set<Ball> repository = new HashSet<>();

    private BallRepository() {
    }

    public static BallRepository getInstance() {
        if (instance == null) {
            instance = new BallRepository();
        }
        return instance;
    }

    @Override
    public Set<Ball> getAllUnmodifiableSet() {
        return Collections.unmodifiableSet(repository);
    }

    @Override
    public void addFigure(Ball figure) {
        logger.info(String.format("Figure added to repository: %s", figure.toString()));
        repository.add(figure);
    }

    @Override
    public void addAll(List<Ball> figureList) {
        repository.addAll(figureList);
    }

    @Override
    public List<Ball> query(BallSpecification specification) {
        return repository.stream().filter(specification::specified).collect(Collectors.toList());
    }

    public List<Ball> query(BallSpecification specification, CompareType type) {
        List<Ball> list = query(specification);
        list.sort(type.getComparatorByType());
        return list;
    }

    @Override
    public boolean removeFigure(Ball figure) {
        return repository.remove(figure);
    }

}
