import { Card, Image } from 'react-bootstrap'

export default function MovieCardItem({ title, urlImage, rating, year }) {
    return (
        <Card key={title} className="sml-card">
            <Card.Body>
                <Card.Title>{title}</Card.Title>
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