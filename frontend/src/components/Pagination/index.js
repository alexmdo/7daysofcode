import Link from 'next/link'
import { Row, Button } from 'react-bootstrap'
import Router from 'next/router';

export default function Pagination({ page, totalPages, isFirst, isLast }) {
    return (
        <Row className='justify-content-md-center'>
            <Link href="/?page=0">
                {` <<`}
            </Link>
            <p>&nbsp;&nbsp;</p>
            <Button onClick={() => Router.push(`/?page=${page - 1}`)} disabled={isFirst}>
                Anterior
            </Button>
            <p>&nbsp;&nbsp;</p>
            <Button onClick={() => Router.push(`/?page=${page + 1}`)} disabled={isLast}>
                Proximo
            </Button>
            <p>&nbsp;&nbsp;</p>
            <Link href={`/?page=${totalPages}`}>
                {` >>`}
            </Link>
        </Row>
    )
}