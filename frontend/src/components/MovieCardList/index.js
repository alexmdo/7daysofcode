import { Container, Row, Card, Image } from 'react-bootstrap'
import MovieCardItem from '../MovieCardItem';
import Pagination from '../Pagination'



export default function MovieCardList({ data, page }) {
    const movies = data.content;
    const isFirst = data.first;
    const isLast = data.last;
    const totalPages = data.totalPages - 1;
    return (
        <Container>
            <Row className="justify-content-md-between">
                {movies.map(({ id, title, urlImage, rating, year }) => (
                    <MovieCardItem key={id} id={id} title={title} urlImage={urlImage} rating={rating} year={year} />
                ))}
            </Row>
            <Pagination page={page} totalPages={totalPages} isFirst={isFirst} isLast={isLast} />
        </Container>
    )
}