import axios from 'axios';
import { Card, CardColumns, Image, Row } from 'react-bootstrap';

export default function MovieCardItem({ id, title, urlImage, rating, year }) {
    
    const favoriteMovie = async(id) => {
        console.log(`id ${id}`)
        try {
            const res = await axios.post('http://localhost:8080/favorite', {
                "movieId": id
            });
            console.log(res);
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <Card key={title} className="sml-card">
            <Card.Body>
                <Card.Title className='d-flex justify-content-between'>
                    {title} <img src="/favorite-star.svg" alt="Favorite Icon" className="sml-logo" onClick={() => favoriteMovie(id)} />
                </Card.Title>
                <Card.Body>
                    <Image src={urlImage} rounded thumbnail fluid>
                    </Image>
                </Card.Body>
                <Card.Footer>
                    Nota: {rating} - Ano: {year}
                </Card.Footer>
            </Card.Body>
        </Card>
    )
}